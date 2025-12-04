output "instance_id" {
  description = "EC2 instance ID"
  value       = aws_instance.web.id
}

output "instance_public_ip" {
  description = "EC2 instance public IP"
  value       = aws_instance.web.public_ip
}

output "application_url" {
  description = "Spring Boot application URL"
  value       = "http://${aws_instance.web.public_ip}:8080"
}

output "ssh_command" {
  description = "SSH connection command"
  value       = "ssh -i ~/.ssh/id_rsa ec2-user@${aws_instance.web.public_ip}"
}
