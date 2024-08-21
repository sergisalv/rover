createMap();


async function  createMap(){
refreshRover();

//Obtenemos la información de los obstaculos

let obstacleResponse = await fetch('/api/obstacle/', {
    method: 'GET',
    headers: {
        'Content-Type' : 'application/json'
    }
});

let obstaclesJson = await obstacleResponse.json();
obstaclesJson.forEach(obstacleJson => {
    //Seteamos todas las rocas
 createRock(obstacleJson.x, obstacleJson.y);   
    
});


}

async function refreshRover(){
    //Obtenemos la información del rover
    let roverResponse = await fetch('/api/rover/', {
        method: 'GET',
        headers: {
            'Content-Type' : 'application/json'
        }
    });

let roverJson = await roverResponse.json();

//Seteamos el Rover
moveRover(roverJson.x, roverJson.y);

rotateRover();


}



function moveRover(x,y){

    document.getElementById("rover").style.left = (x * 100) + 'px'
    document.getElementById("rover").style.top = (y * 100) + 'px'

    playMoveSound()

}

async function rotateRover(){
    //Obtenemos la información del rover
    let roverResponse = await fetch('/api/rover/', {
        method: 'GET',
        headers: {
            'Content-Type' : 'application/json'
        }
    });

    let roverJson = await roverResponse.json();

    if (roverJson.direction == "NORTH"){
        document.getElementById('rover').setAttribute("src", "images/robotNorte.png");
    } else if (roverJson.direction == "EAST"){
        document.getElementById('rover').setAttribute("src", "images/robotEste.png");
    } else if (roverJson.direction == "SOUTH"){
        document.getElementById('rover').setAttribute("src", "images/robotSur.png");
    } else if (roverJson.direction == "WEST"){
        document.getElementById('rover').setAttribute("src", "images/robotOeste.png");
    }
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
    sendCommand("L")
}

function clickBtnRotateRight(){
    sendCommand("R")
    }


async function moveForward(){
    sendCommand("F")
}

function moveBack(){
    sendCommand("B")
}

async function sendCommand(command) {
    let requestBody = {
        "commands" : [command]
    };
    await fetch('/api/rover/command/', {
        method: 'POST',
        headers: {
            'Content-Type' : 'application/json'
        },
        body: JSON.stringify(requestBody)
    });
   await refreshRover();
}

function playMoveSound(){
    var audioElement = document.createElement("audio");
        audioElement.src = "sounds/move.wav";
        audioElement.controls = true;
        audioElement.autoplay = true;
        document.getElementById("container").appendChild(audioElement);

}