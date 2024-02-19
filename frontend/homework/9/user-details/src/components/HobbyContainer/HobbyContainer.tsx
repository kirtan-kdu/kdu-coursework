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
        <ul className='hobby-list'>
            {hobbies.map((hobbyObj) => {
                return <li key={hobbyObj.id}>{hobbyObj.hobby}</li>;
            })}
        </ul>
    );
}

export default HobbyContainer;
