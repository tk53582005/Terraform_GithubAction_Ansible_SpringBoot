# 動画43課題：Terraform × Ansible × GitHub Actions による Spring Boot 自動デプロイ

## 1. 実装内容

GitHub への push をトリガーに以下を自動実行する CI/CD パイプラインを構築

- Terraform：EC2・Security Group・Key Pair の作成
- GitHub Actions：Lint → Build → Plan → Manual Approval → Apply → Ansible の実行
- Ansible：Java 17 のセットアップ、Spring Boot アプリの配置・起動

## 2. 動作確認

- GitHub Actions 全ステップ成功
- EC2 上で Spring Boot アプリ起動確認  
- Manual Approval が正しく動作することを確認

## 3. 事前準備

### 3-1. Terraform Backend の準備

Terraform のリモートステートを使用するため、事前に以下を AWS 上で作成：

- S3 バケット（Terraform state 用）
- DynamoDB テーブル（state lock 用）

### 3-2. GitHub Actions の変数設定

リポジトリの Settings → Variables に以下を登録：

- `MY_IP`：作業端末のグローバルIP（CIDR）

**my_ip の指定方法：**
- CI/CD（GitHub Actions）: リポジトリ Variables の `MY_IP` から自動取得
- ローカル実行: `-var="my_ip=YOUR_IP/32"` で指定

### 3-3. セキュリティグループ

Terraform の egress は外部パッケージ取得や Ansible 動作のために 0.0.0.0/0 を許可
