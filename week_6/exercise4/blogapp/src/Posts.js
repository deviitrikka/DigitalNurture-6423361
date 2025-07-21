import React, { Component } from 'react'

export default class Posts extends Component {
    constructor(props){
        super(props);
        this.state = {
            posts : []
        }
    }

    loadPosts(){
        fetch("https://jsonplaceholder.typicode.com/posts")
        .then(response => (response.json()))
        .then(data => {
            this.setState({posts : data})
        })
    }
    componentDidMount(){
        this.loadPosts();
    }
  render() {
    return (
      <div>
        <div><h2>Posts</h2></div>
        <div>{this.state.posts.map(post => (
            <div key={post.id}>
                <h3>{post.title}</h3>
                <h3>{post.body}</h3>
            </div>
        ))}</div>
      </div>
    )
  }

  componentDidCatch(error, info){
    console.log(error);
    console.log(info);    
  }
}
