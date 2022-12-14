-- テーブル作成
-- ユーザーテーブル
CREATE TABLE `users`
(
    `id`         INT          NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `username`   VARCHAR(256) NOT NULL COMMENT 'ユーザーID',
    `email`      VARCHAR(256) NOT NULL COMMENT 'メールアドレス',
    `password`   BINARY(60)   NOT NULL COMMENT 'パスワード (BCrypt)',
    `created_at` DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '登録日時',
    `updated_at` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
    `deleted_at` DATETIME DEFAULT NULL COMMENT '削除日時',
    PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT = 'ユーザーテーブル';
-- 投稿テーブル
CREATE TABLE `posts`
(
    `id`         INT          NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `user_id`    INT          NOT NULL COMMENT '投稿者ユーザーID',
    `text`       VARCHAR(140) NOT NULL COMMENT '投稿本文',
    `created_at` DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '登録日時',
    `updated_at` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
    `deleted_at` DATETIME DEFAULT NULL COMMENT '削除日時',
    PRIMARY KEY (id),
    FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT = '投稿テーブル';
-- いいねテーブル
CREATE TABLE `favorites`
(
    `user_id` INT NOT NULL COMMENT 'ユーザーID',
    `post_id` INT NOT NULL COMMENT '投稿ID',
    FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
    FOREIGN KEY (`post_id`) REFERENCES `posts` (`id`),
    PRIMARY KEY (`user_id`, `post_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT = 'いいねテーブル';

-- データ挿入
# ユーザーデータ
INSERT INTO users (username, email, password)
VALUES ('山田太郎', 'test@example.com', '$2a$08$W0kLGEd0VolF.ZUXlub9ge6iI0QQVbmgtiuCw0ijFJjfo0ZkJmLta'),
       ('田中花子', 'test2@example.com', '$2a$08$W0kLGEd0VolF.ZUXlub9ge6iI0QQVbmgtiuCw0ijFJjfo0ZkJmLta');
# 投稿データ
INSERT INTO posts (user_id, text)
VALUES (1, '今日の晩御飯は美味しかった。by 山田太郎'),
       (2, '今日の晩御飯はまずかった。 by 田中花子'),
       (1, 'おはよう by 山田太郎'),
       (2, '今日の晩御飯はまずかった。 by 田中花子'),
       (1, 'おはよう by 山田太郎'),
       (2, '今日の晩御飯はまずかった。 by 田中花子'),
       (1, 'おはよう by 山田太郎'),
       (2, '今日の晩御飯はまずかった。 by 田中花子'),
       (2, '今日の晩御飯はまずかった。 by 田中花子'),
       (2, '今日の晩御飯はまずかった。 by 田中花子'),
       (2, '今日の晩御飯はまずかった。 by 田中花子'),
       (2, '今日の晩御飯はまずかった。 by 田中花子'),
       (2, '今日の晩御飯はまずかった。 by 田中花子');
# 太郎から花子の投稿へのいいね
INSERT INTO favorites (user_id, post_id)
VALUES (1, 2);
