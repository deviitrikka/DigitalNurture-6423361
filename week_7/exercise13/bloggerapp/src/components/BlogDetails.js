import React from 'react'

const BlogDetails = () => {
    const blogs = [
        {id:1, name:"React Learning", author:"Stephen Biz", description:"Welcome to learning React!"},
        {id:2, name:"Installation", author:"Schewzdenier", description:"You can install React via npm"}
    ]
  return (
    <div>
        <h2>Blog Details</h2>
        {blogs.map((blog)=>(
            <div>
           <h4>{blog.name}</h4> 
            <h5>{blog.author}</h5>
            <h6>{blog.description}</h6>
           </div>
        ))}
    </div>
  )
}

export default BlogDetails