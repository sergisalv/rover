function  createMap(){
    // Llamado al backend

    moveRover(2,3);
    createRock(4,5);
    createRock(1,1);
    createRock(4,7);
    createRock(8,8);

}



function moveRover(x,y){

    document.getElementById("rover").style.left = (x * 100) + 'px'
    document.getElementById("rover").style.top = (y * 100) + 'px'

    playMoveSound()

}

function createRock(x,y){
    var rock = document.createElement("img");
    rock.setAttribute("src", "images/rock.png");
    rock.setAttribute("class", "rock");
    var container = document.getElementById("container");
    container.appendChild(rock);

    rock.style.left = (x * 100 + 'px')
    rock.style.top = (y * 100 + 'px')

}



function clickBtnRotateLeft(){
    alert("Left");
}

function clickBtnRotateRight(){
    alert("Right");
}

function moveForward(){
    alert("Forward");
}

function moveBack(){
    alert("Backward");
}

function playMoveSound(){
    var audioElement = document.createElement("audio");
        audioElement.src = "sounds/move.wav";
        audioElement.controls = true;
        audioElement.autoplay = true;
        document.getElementById("container").appendChild(audioElement);

}