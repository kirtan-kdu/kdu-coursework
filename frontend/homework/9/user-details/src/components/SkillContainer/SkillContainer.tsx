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
        <ul className='skills-list'>
            {skills.map((skillObj) => {
                return <li key={skillObj.id}>{skillObj.skill}</li>;
            })}
        </ul>
    );
}

export default SkillContainer;
