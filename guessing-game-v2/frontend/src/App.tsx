import Home from "./pages/Home";


import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import { Blog } from './components/Blog'


function App() {
  const [count, setCount] = useState(0)

  return (
    <>
    <div>
      <Home />
    </div>
    </>
  )
}

export default App