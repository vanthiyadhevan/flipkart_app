pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                script {
                    // Use the official Maven image for building
                    docker.image('maven:3.8.4-openjdk-17-slim').inside('-v $HOME/.m2:/root/.m2') {
                        // Set the working directory
                        dir('/app') {
                            // Copy the POM file and download dependencies
                            sh 'cp /path/to/your/project/pom.xml .'
                            sh 'mvn dependency:go-offline -B'
                        }
                    }
                }
            }
        }

        stage('Test') {
            steps {
                script {
                    // Use the official Maven image for testing
                    docker.image('maven:3.8.4-openjdk-17-slim').inside('-v $HOME/.m2:/root/.m2') {
                        // Set the working directory
                        dir('/app') {
                            // Copy the application source code
                            sh 'cp -r /path/to/your/project/src .'
                            // Run tests
                            sh 'mvn test'
                        }
                    }
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    // Use Docker for building the image
                    docker.build('open_cart_app', '-f /path/to/your/project/Dockerfile .')
                }
            }
        }

        stage('Deploy') {
            steps {
                script {
                    // Run Docker container
                    docker.image('open_cart_app').withRun('-p 8880:80') {
                        // Your deployment steps go here if needed
                    }
                }
            }
        }
    }

    post {
        always {
            // Clean up
            script {
                docker.image('open_cart_app').remove()
            }
        }
    }
}
