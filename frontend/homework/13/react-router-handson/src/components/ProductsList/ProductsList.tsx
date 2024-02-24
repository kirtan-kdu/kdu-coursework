import { useContext } from "react";
import { useStyles } from "./ProductList.styles.ts";
import ProductCard from "./ProductCard/ProductCard";
import { ProductListContext } from "../../contexts/ProductListProvider.tsx";

const ProductsList = () => {
    const { productsList, setProductsList } = useContext(ProductListContext);

    const classes = useStyles();

    productsList.length === 0 &&
        fetch("https://fakestoreapi.com/products")
            .then((response) => {
                if (!response.ok) {
                    throw new Error("Network response was not ok");
                }
                return response.json();
            })
            .then((data) => {
                console.log(data);
                setProductsList(data);
            })
            .catch((error) => {
                console.error(
                    "There has been a problem with your fetch operation:",
                    error
                );
            });

    return (
        <div className={classes.mainContainer}>
            <div className='main-heading'>
                <h1>
                    KDU <span>MARKETPLACE</span>
                </h1>
            </div>
            <div className='productlist-container'>
                {productsList.map((product) => (
                    <ProductCard
                        key={product.id}
                        product={product}
                    ></ProductCard>
                ))}
            </div>
        </div>
    );
};

export default ProductsList;
