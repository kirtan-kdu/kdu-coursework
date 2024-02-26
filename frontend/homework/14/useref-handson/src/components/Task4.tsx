import { useRef } from "react";

const Task4 = () => {
    const scrollToTopRef = useRef<HTMLDivElement>(null);

    const scrollToTop = () => {
        if (scrollToTopRef.current) {
            scrollToTopRef.current.scrollTo({ top: 0, behavior: "smooth" });
        }
    };

    return (
        <div
            ref={scrollToTopRef}
            className='scroll-container'
            style={{ height: "30rem", overflow: "auto" }}
        >
            <h1>
                Builders. Not box checkers. We are enterprise-grade engineers,
                architects, and strategists. With a design-driven philosophy,
                our development approach decreases technical debt, improves
                customer experiences, and increases enterprise value. We partner
                with both investors and their portfolio companies across the
                full lifecycle - from diligence through divestiture – to
                identify, plan, and execute technology strategies for revenue
                growth, profit optimization, and value enhancement. Our work
                pre- and post-transaction is investment-driven - from our proven
                maturity assessment model to our value creation solutions, we
                bring real-world operating wisdom to your process. Builders. Not
                box checkers. We are enterprise-grade engineers, architects, and
                strategists. With a design-driven philosophy, our development
                approach decreases technical debt, improves customer
                experiences, and increases enterprise value. We partner with
                both investors and their portfolio companies across the full
                lifecycle - from diligence through divestiture – to identify,
                plan, and execute technology strategies for revenue growth,
                profit optimization, and value enhancement. Our work pre- and
                post-transaction is investment-driven - from our proven maturity
                assessment model to our value creation solutions, we bring
                real-world operating wisdom to your process.
            </h1>
            <button onClick={scrollToTop}>Scroll To Top</button>
        </div>
    );
};

export default Task4;
