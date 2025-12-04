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
