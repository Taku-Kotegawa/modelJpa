-- liquibase formatted sql

-- changeset taku:1690616815434-1
CREATE TABLE "test_master" ("id" VARCHAR(255) NOT NULL, "test" VARCHAR(255), CONSTRAINT "test_master_pkey" PRIMARY KEY ("id"));
COMMENT ON TABLE "test_master" IS 'テストマスター';
COMMENT ON COLUMN "test_master"."id" IS '主キー';
COMMENT ON COLUMN "test_master"."test" IS 'テスト項目';

