node {
    //  instructions
    // parameter
    //Build trigger
    stage("git pull"){ 
        git "git@github.com:danfmihai/jenkins-pipeline.git"
    }    

    stage("Install apache"){
        sh "ssh ec2-user@${DEVIP}  sudo yum install httpd -y"
    }

    stage("Start apache"){
        sh "ssh ec2-user@${DEVIP} sudo systemctl start httpd"
    }

    stage("Copy files"){
        sh "rsync -aP --delete index.html ec2-user@${DEVIP}:/tmp"
    }    

    stage("Move files"){
        sh "ssh ec2-user@${DEVIP}  sudo cp -f /tmp/index.html /var/www/html/index.html"
    } 


}