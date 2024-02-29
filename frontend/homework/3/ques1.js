const billAmounts = [140, 45, 280];

const tipCalculator = (billAmounts) => {
  const tips = billAmounts.map((amount) => {
    if (amount < 50) return 0.2 * amount;
    else if (amount > 200) return 0.1 * amount;
    else return 0.15 * amount;
  });

  const totalAmount = billAmounts.map((val, idx) => val + tips[idx]);

  return [tips, totalAmount];
};

console.log(tipCalculator(billAmounts));
