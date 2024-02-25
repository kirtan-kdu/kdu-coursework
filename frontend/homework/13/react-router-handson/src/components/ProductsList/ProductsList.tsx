import { useContext } from "react";
import { useStyles } from "./ProductList.styles.ts";
import ProductCard from "./ProductCard/ProductCard";
import { ProductListContext } from "../../contexts/ProductListProvider.tsx";
import { FilterParamsContext } from "../../contexts/FilterParamsProvider.tsx";
import { IProduct } from "../../types/Product.type.ts";

const ProductsList = () => {
    const { productsList, setProductsList, setCatagoryList } =
        useContext(ProductListContext);

    const classes = useStyles();

    const {
        searchString,
        categoryFilter: catagoryFilter,
        sortBy,
    } = useContext(FilterParamsContext);

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
                setCatagoryList(
                    Array.from(
                        new Set(
                            data.map((product: IProduct) => product.category)
                        )
                    )
                );
            })
            .catch((error) => {
                console.error(
                    "There has been a problem with your fetch operation:",
                    error
                );
            });

    const sortProducts = (productsList: IProduct[], sortBy: string) => {
        switch (sortBy) {
            case "price":
                return [...productsList].sort((a, b) => a.price - b.price);
            case "name":
                return [...productsList].sort((a, b) =>
                    a.title.localeCompare(b.title)
                );
            case "rating":
                return [...productsList].sort(
                    (a, b) => b.rating.rate - a.rating.rate
                );
            default:
                return productsList;
        }
    };

    const sortedProducts = sortProducts(
        productsList.filter(
            (product) =>
                product.category === catagoryFilter || catagoryFilter === ""
        ),
        sortBy
    );

    const filteredProducts = sortedProducts.filter((product) =>
        product.title.toLowerCase().includes(searchString.toLowerCase())
    );

    return (
        <div className={classes.mainContainer}>
            <div className='main-heading'>
                <h1>
                    KDU <span>MARKETPLACE</span>
                </h1>
            </div>
            <div className='productlist-container'>
                {filteredProducts.map((product) => (
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
