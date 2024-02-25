import React, {
    Dispatch,
    SetStateAction,
    createContext,
    useMemo,
    useState,
} from "react";
import { IProduct } from "../types/Product.type";

interface IProductList {
    productsList: IProduct[];
    setProductsList: Dispatch<SetStateAction<IProduct[]>>;
    catagoryList: string[];
    setCatagoryList: Dispatch<SetStateAction<string[]>>;
}

export const ProductListContext = createContext<IProductList>({
    productsList: [],
    setProductsList: () => {},
    catagoryList: [],
    setCatagoryList: () => {},
});

interface ProductListProviderProps {
    children: React.ReactNode;
}

export const ProductListProvider = ({ children }: ProductListProviderProps) => {
    const [productsList, setProductsList] = useState<IProduct[]>([]);
    const [catagoryList, setCatagoryList] = useState<string[]>([]);

    const value = useMemo(
        () => ({
            productsList,
            setProductsList,
            catagoryList,
            setCatagoryList,
        }),
        [productsList, catagoryList]
    );
    return (
        <ProductListContext.Provider value={value}>
            {children}
        </ProductListContext.Provider>
    );
};
