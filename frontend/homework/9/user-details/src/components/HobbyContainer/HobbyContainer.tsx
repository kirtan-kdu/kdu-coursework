import React from "react";
import "./HobbyContainer.scss";

interface IHobby {
    id: number;
    hobby: string;
}

interface IHobbyProp {
    hobbies: IHobby[];
}

function HobbyContainer({ hobbies }: IHobbyProp) {
    return (
        <div className='hobby-list'>
            <h1>Hobbies</h1>
            <ul>
                {hobbies.map((hobbyObj) => {
                    return <li key={hobbyObj.id}>{hobbyObj.hobby}</li>;
                })}
            </ul>
        </div>
    );
}

export default HobbyContainer;
