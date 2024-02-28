import { IProduct } from "../../../types/Product.type";
import { Link } from "react-router-dom";
import { capitalizeFirstLetter } from "../../../utils/utils";

interface IProductCardProps {
    product: IProduct;
}

const ProductCard = ({ product }: IProductCardProps) => {
    return (
        <Link
            className='prod-link'
            key={product.id}
            to={`/product/${product.id}`}
            style={{
                color: "inherit",
                textDecoration: "inherit",
            }}
        >
            <div key={product.id} className='product-card'>
                <div className='prod-heading'>
                    <h1 className='prod-catagory'>
                        {capitalizeFirstLetter(product.category)}
                    </h1>
                    <h1 className='prod-rating'>{product.rating.rate} ⭐</h1>
                </div>
                <div className='prod-image-wrapper'>
                    <img
                        className='prod-image'
                        src={product.image}
                        alt='product'
                    />
                </div>

                <div className='prod-footer'>
                    <h1 className='prod-title'>{product.title}</h1>
                    <h1 className='prod-price'>{product.price} $</h1>
                </div>
            </div>
        </Link>
    );
};

export default ProductCard;
