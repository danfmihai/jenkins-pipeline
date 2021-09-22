node {
    //  instructions
    // parameter
    //Build trigger
    stage("git pull") 
        git "git@github.com:danfmihai/jenkins-pipeline.git"
}