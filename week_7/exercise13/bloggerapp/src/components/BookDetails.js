import React from 'react'

const BookDetails = () => {
    const books = [
        {id:1, name:"Master React", price:670},
        {id:2, name:"Deep Dive Into Angular 11", price:800},
        {id:1, name:"Mongo Essentials", price:450},
    ]
  return (
    <div>
        <h2>Book Details</h2>
        {books.map((book)=>(
            <div key={book.id}>
                <h4>{book.name}</h4>
                <h6>{book.price}</h6>
            </div>
        ))}
    </div>
  )
}

export default BookDetails