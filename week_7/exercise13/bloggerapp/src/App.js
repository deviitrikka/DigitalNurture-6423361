import { useState } from 'react';
import './App.css';
import BlogDetails from './components/BlogDetails';
import BookDetails from './components/BookDetails';
import CourseDetails from './components/CourseDetails';

function App() {
  const [selected, setSelected] = useState('');

  // 1. if/else outside JSX
  let componentToRender;
  if (selected === 'book') {
    componentToRender = <BookDetails />;
  } else if (selected === 'blog') {
    componentToRender = <BlogDetails />;
  } else if (selected === 'course') {
    componentToRender = <CourseDetails />;
  }

  // 2. switch case (IIFE in JSX below)
  const renderWithSwitch = () => {
    switch (selected) {
      case 'book':
        return <BookDetails />;
      case 'blog':
        return <BlogDetails />;
      case 'course':
        return <CourseDetails />;
      default:
        return null;
    }
  };

  // 3. Object Mapping
  const componentMap = {
    book: <BookDetails />,
    blog: <BlogDetails />,
    course: <CourseDetails />,
  };

  return (
    <div className="App">
      <h1>Blogger App</h1>

      <div>
        <button onClick={() => setSelected('book')}>Book</button>
        <button onClick={() => setSelected('blog')}>Blog</button>
        <button onClick={() => setSelected('course')}>Course</button>
        <button onClick={() => setSelected('')}>Clear</button>
      </div>

      <hr />

      <h3>1. if/else outside JSX</h3>
      {componentToRender}

      <h3>2. Ternary Operator</h3>
      {selected === 'book' ? <BookDetails /> : selected === 'blog' ? <BlogDetails /> : selected === 'course' ? <CourseDetails /> : <p>Please select something.</p>}

      <h3>3. Logical AND (short-circuit)</h3>
      {selected === 'book' && <BookDetails />}
      {selected === 'blog' && <BlogDetails />}
      {selected === 'course' && <CourseDetails />}

      <h3>4. IIFE + switch</h3>
      {(() => renderWithSwitch())()}

      <h3>5. Object Mapping</h3>
      {componentMap[selected] || <p>Choose a component to view.</p>}
    </div>
  );
}

export default App;
