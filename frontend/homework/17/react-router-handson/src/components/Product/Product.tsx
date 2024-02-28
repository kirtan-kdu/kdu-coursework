import { Link, useParams } from "react-router-dom";
import { useStyles } from "./Product.styles";
import { useSelector } from "react-redux";
import { RootState } from "../../redux/Store";

const Product = () => {
    const { id } = useParams();

    const productsList = useSelector(
        (state: RootState) => state.productListReducer.productsList
    );

    const product = productsList.filter((prod) => prod.id == Number(id))[0];
    const classes = useStyles();

    return (
        <div className={classes.prodContainer}>
            <h1 className='prod-title'>{product.title}</h1>
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
                    <Link to={"/"}>
                        <button className='redirect-btn'>
                            Back to Products
                        </button>
                    </Link>
                </div>
            </div>
        </div>
    );
};

export default Product;
