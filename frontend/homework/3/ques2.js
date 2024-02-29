const days = [
  "Sunday   ",
  "   Monday  ",
  "  Tuesday",
  "Wednesday  ",
  "  Thursday   ",
  "   Friday",
  "Saturday    ",
];

const uncoded = [
  "javascript is cool  ",
  "programming is fun",
  "  become a coder",
];

const convertAbbreviated = (days) => {
  return days.map((day) => day.trim().toUpperCase().slice(0, 3));
};

const encode = (uncoded) => {
  return uncoded.map((str) =>
    str
      .trim()
      .replace(/a/g, "4")
      .replace(/e/g, "3")
      .replace(/i/g, "1")
      .replace(/o/g, "0")
      .replace(/s/g, "5")
  );
};

console.log(convertAbbreviated(days));
console.log(encode(uncoded));
