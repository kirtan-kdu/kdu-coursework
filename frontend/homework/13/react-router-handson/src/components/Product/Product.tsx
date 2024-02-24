import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import { IProduct } from "../../types/Product.type";
import { useStyles } from "./Product.styles";

const Product = () => {
    const { id } = useParams();

    const navigate = useNavigate();
    const [product, setProduct] = useState<IProduct>();

    const classes = useStyles();

    const goBackToMainPage = () => {
        navigate(-1);
    };

    useEffect(() => {
        fetch(`https://fakestoreapi.com/products/${id}`)
            .then((response) => {
                if (!response.ok) {
                    throw new Error("Network response was not ok");
                }
                return response.json();
            })
            .then((data) => {
                console.log(data);
                setProduct(data);
            })
            .catch((error) => {
                console.error(
                    "There has been a problem with your fetch operation:",
                    error
                );
            });
    }, [id]);
    return (
        <div className={classes.prodContainer}>
            <h1 className='prod-title'>{product?.title}</h1>
            <div className='prod-details'>
                <div className='prod-image-container'>
                    <img
                        className='prod-look'
                        src={product?.image}
                        alt='product look'
                    />
                </div>
                <div className='right-details'>
                    <h1 className='prod-name'>Product: {product?.title}</h1>
                    <h1 className='prod-price'>Price: $ {product?.price}</h1>
                    <h1 className='prod-des-title'>Product Description:</h1>
                    <h1 className='prod-des'>{product?.description}</h1>
                    <div className='prod-rating-container'>
                        <h1 className='prod-review'>
                            Reviews: <span>{product?.rating.count}</span>
                        </h1>
                        <h1 className='prod-rating'>
                            Rating: <span>{product?.rating.rate} ⭐</span>
                        </h1>
                    </div>
                    <button onClick={goBackToMainPage} className='redirect-btn'>
                        Back to Products
                    </button>
                </div>
            </div>
        </div>
    );
};

export default Product;
