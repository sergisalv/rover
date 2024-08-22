
createMap();


async function  createMap(){
refreshRover("A");

let obstaclesJson = await getObstacles();

sendCommand("C");

obstaclesJson.forEach(obstacleJson => {
    //Seteamos todas las rocas
 createRock(obstacleJson.x, obstacleJson.y);

});


}

async function getObstacles(){
//Obtenemos la información de los obstaculos

let obstacleResponse = await fetch('/api/obstacle/', {
    method: 'GET',
    headers: {
        'Content-Type' : 'application/json'
    }
});

let obstaclesJson = await obstacleResponse.json();
return obstaclesJson;
    
}

async function getRover(){
     //Obtenemos la información del rover
     let roverResponse = await fetch('/api/rover/', {
        method: 'GET',
        headers: {
            'Content-Type' : 'application/json'
        }
    });

let roverJson = await roverResponse.json();
return roverJson;
}

async function refreshRover(command){

let roverJson = await getRover();
let obstaclesJson = await getObstacles();
/*obstaclesJson.forEach(obstacleJson => {
    if ((roverJson.x === obstacleJson.x) && (roverJson.y === obstacleJson.y)){
        alert("Un obstáculo impide el paso");
        switch (command){
            case "F":
                moveBack();
                break;
            case "B":
                moveForward();
                break;
        }
    }
         
   
}); */

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
   await refreshRover(command);
}

function playMoveSound(){
    var audioElement = document.createElement("audio");
        audioElement.src = "sounds/move.wav";
        audioElement.controls = true;
        audioElement.autoplay = true;
        document.getElementById("container").appendChild(audioElement);

}