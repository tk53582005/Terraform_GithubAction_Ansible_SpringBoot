terraform {
  backend "s3" {
    bucket         = "tk53582005-terraform-state"
    key            = "springboot-cicd/terraform.tfstate"
    region         = "ap-northeast-1"
    encrypt        = true
    dynamodb_table = "terraform-state-lock"
  }
}
