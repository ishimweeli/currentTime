pipeline {
    agent any
    parameters {
        choice(name: 'ENVIRONMENT', description: 'Environment to deploy', choices: ['dev', 'qa', 'prod'])
    }
    stages {
        stage('Build') {
            steps {
                bat 'mvn clean package'
            }
        }
        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }
        stage('Code Coverage') {
            steps {
                bat 'mvn jacoco:report'
                publishHTML(target: [
                    reportDir: 'target/site/jacoco',
                    reportFiles: 'index.html',
                    reportName: 'Code Coverage Report'
                ])
            }
        }
        stage('Build Docker Image') {
            steps {
                bat 'docker build -t my-time-app .'
            }
        }
    }
}
