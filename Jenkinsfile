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
        stage('Code Coverage and Test Results') {
            steps {
                // Generate code coverage report
                bat 'mvn jacoco:report'

                // Publish code coverage report
                jacoco execPattern: '**/target/jacoco.exec',
                       classPattern: '**/target/classes',
                       sourcePattern: '**/src/main/java',
                       exclusionPattern: '**/target/test-classes'

                // Publish code coverage HTML report
                publishHTML(target: [
                    allowMissing: false,
                    alwaysLinkToLastBuild: true,
                    keepAll: true,
                    reportDir: 'target/site/jacoco',
                    reportFiles: 'index.html',
                    reportName: 'Code Coverage Report (HTML)'
                ])

                // Publish JUnit test results XML report
                junit '**/target/surefire-reports/*.xml'
            }
        }
        stage('Build Docker Image') {
            steps {
                bat 'docker build -t my-time-app .'
            }
        }
    }
}
