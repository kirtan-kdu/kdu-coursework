import React from "react";
import SkillContainer from "./SkillContainer/SkillContainer";
import HobbyContainer from "./HobbyContainer/HobbyContainer";
import "./UserContainer.scss";

interface ISkill {
    id: number;
    skill: string;
}

interface IHobby {
    id: number;
    hobby: string;
}

interface IUser {
    name: string;
    fullName: string;
    qualification: string;
    skills: ISkill[];
    hobbies: IHobby[];
}

interface IUserProp {
    userDetails: IUser;
}

function UserContainer({ userDetails }: IUserProp) {
    return (
        <div className='main-container'>
            <h1>{userDetails.name}</h1>
            <h2>{userDetails.fullName}</h2>
            <h1>{userDetails.qualification}</h1>
            <div className='wrapper'>
                <SkillContainer skills={userDetails.skills} />
                <HobbyContainer hobbies={userDetails.hobbies} />
            </div>
        </div>
    );
}

export default UserContainer;
