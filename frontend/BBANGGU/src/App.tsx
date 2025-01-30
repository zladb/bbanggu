import React from "react"
import { BrowserRouter as Router, Route, Routes } from "react-router-dom"
import UserMain from "./pages/user/UserMain"
import BakeryDetail from "./pages/user/BakeryDetail"
import "./styles/fonts.css"

function App() {
  return (
    <Router>
      <div className="w-full min-h-screen bg-white overflow-x-hidden font-['Pretendard']">
        <div className="mx-auto min-w-[300px] max-w-[600px]">
          <Routes>
            <Route path="/" element={<UserMain />} />
            <Route path="/bakery/:name" element={<BakeryDetail />} />
          </Routes>
        </div>
      </div>
    </Router>
  )
}

export default App

