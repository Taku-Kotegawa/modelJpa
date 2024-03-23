# Modeling Tool used by JPA(Hibernate)

JPA(Hibernate)を使ったモデリング・DDL作成ツール

## 目的

苦手な物理テーブル設計(DDLの作成)をJPA(Hibernate)とLiquibaseにやってもらうツール。モデリングを確認できる様にJIGも同梱。

作成したDDLはMyBatisおよびMyBatisGeneratorを使う別プロジェクトで使う想定のため、確認用にMyBatisGenerator-maven-pluginも使えるようにしている。

## 前提知識
- JPAでエンティティクラスを作成できること(JPAアノテーションの知識)

## 実行環境
- JDK 21 (17でも動くと思う)
- postgres
- Graphviz

## 使い方の流れ
1. postgresを起動し、"modeljpa"の名前でデータベースを作成
1. Enumやエンティティクラスを作成
1. JIGで設計を確認
1. JPA(Hibernate)でエンティティからテーブルを作成
1. LiquibaseでDDLを生成
1. DDLを別プロジェクトに移植し、テーブル作成
1. MyBatis-GeneratorでModel&Mapperの生成 (このプロジェクト内でも生成できる様にしている)


## 操作方法

- JIG
  - Mavenメニューより Plugins → jig → jig:jig

- JPA(Hibernate)でテーブル作成
  - アプリケーションを起動するとテーブルが作成される
  - spring.jpa.hibernate.ddl-auto=create で挙動を変更できる

- LiquibaseでDDLを生成
    - (全件) Mavenメニューより Plugins → liquibase → liquibase:generateChangeLog ※1
    - (差分) Mavenメニューより Plugins → liquibase → liquibase:diff ※2
    - ※１ 出力先ファイルの上書きができないため、db.changelog-generated.sqlを事前に削除すること
    - ※２ liquibase.properties の referenceUrlに指定したDBに変更前の状態が必要

- MyBatis-Generator
  - Mavenメニューより Plugins → mybatis-generator → mybatis-generator:generate ※３
  - ※３ テーブルを追加した場合など、generatorConfig.xml の設定が必要

## その他
- Linux(Mint), Intellij IDEA の環境で動作確認している。

## 利用ライブラリ
- JPA(Hibernate)
- [Liquibase](https://docs.liquibase.com/home.html)
- [jig](https://github.com/dddjava/jig)
- [jig maven plugin](https://github.com/irof/jig-maven-plugin)
- [MyBatis Generator](https://mybatis.org/generator/)

## 参考
- https://github.com/dddjava/jig-tutorial
- [SpringBootでEntity設計時に知りたいアノテーション](https://qiita.com/ughirose/items/5d691adc677aa08636b8)

## かんたんなJPA

### テーブル(エンティティクラス)
```java
@Comment("従業員")
@Entity(name = "t_empoyee")
public class Employee extends AbstractEntity<Long> { }
```

### 主キー
```java
@Comment("内部ID")
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY) //自動発番
private Long id;
```
複合主キーは、@Idを複数設定する。

### フィールド
- NOT NULL の設定
```java
@Comment("都道府県")
@Column(nullable = false)
private Integer companyPrefecture;
```

- 自動で設定される属性を変更する。String -> varchar(255)
```java
@Comment("備考")
@Column(columnDefinition = "TEXT")
private String companyRemark;
```

- 複数の値を持つ場合
```java
@Comment("添付ファイル")
@ElementCollection
private List<String> companyFile;
```

- Enumを属性に設定
```java
@Comment("有効／無効")
@Enumerated(EnumType.STRING)
private ValidStatus invalidFlag;
```

- 1:nのリレーションを貼る
```java
@Comment("活動履歴")
@OneToMany
@JoinColumn(foreignKey = @ForeignKey(name="t_company_fkey01"))
private List<Activity> activity;
```
- インデックスを追加する
```java
@Table(indexes = {@Index(columnList = "entityType, entityId, stepNo, employeeId", unique = true)})
public class Workflow extends AbstractEntity<Long> implements Serializable {
```

### 設定方法がわかっていない事項
- 別テーブルとOneToOne(1:1)のリレーションを設定すること