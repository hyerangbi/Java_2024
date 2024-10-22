import React from 'react'
import styled from 'styled-components'

const Product = styled.div`
    border: 1px solid white;
    border-radius: 1rem;
    color: white;
    font-size: 2rem;
    font-weight: bold;
    text-align: center;
    padding: ${(props) => props.padding};
    background-color: ${(props) => props.backgroudColor};
`
const Wrapper = styled.div`
    padding: 1rem;
    display: flex;
    flex-direction: row;
    align-items: flex-start;
    justify-content: flex-start;
    background-color: #e2e2e2;
`

const productItems = [
    {
        label: "삼성 TV",
        padding: "1rem",
        backgroudColor:"#f7d3d3"
    },
    {
        label: "LG TV",
        padding: "3rem",
        backgroudColor:"#d3e9f7"
    },
    {
        label: "샤오미 TV",
        padding: "2rem",
        backgroudColor:"#dcf8ef"
    }
]

const Products = () => {
  return (
    <Wrapper>
        {
            productItems.map(item =>{
                return (
                    <Product
                        padding = {item.padding}
                        backgroudColor = {item.backgroudColor}
                    >     
                        {item.label}               
                   </Product>                    
                )
            })
        }
    </Wrapper>
  )
}

export default Products