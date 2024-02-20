import React from "react";
import "./SkillContainer.scss";
interface ISkill {
    id: number;
    skill: string;
}

interface ISkillProps {
    skills: ISkill[];
}
function SkillContainer({ skills }: ISkillProps) {
    return (
        <div className='skills-list'>
            <h1>Skills</h1>
            <ul>
                {skills.map((skillObj) => {
                    return <li key={skillObj.id}>{skillObj.skill}</li>;
                })}
            </ul>
        </div>
    );
}

export default SkillContainer;
