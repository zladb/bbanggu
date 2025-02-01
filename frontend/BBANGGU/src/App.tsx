import { Routes, Route, Navigate } from "react-router-dom"
import OnboardingPage from "./pages/onboarding"
import LoginPage from "./pages/login"
import SignupPage from "./pages/signup"
import CustomerSignupPage from "./pages/signup/customer"
import OwnerSignupPage from "./pages/signup/owner"
import { Router } from "lucide-react"
import MobileLayout from "./layouts/MobileLayout"


export default function App() {
  return (

        <Routes>
          <Route path="/" element={<Navigate to="/onboarding" replace />} />
          <Route path="/onboarding" element={<OnboardingPage />} />
          <Route path="/login" element={<LoginPage />} />
          <Route path="/signup" element={<SignupPage />} />
          <Route path="/signup/customer" element={<CustomerSignupPage />} />
          <Route path="/signup/owner" element={<OwnerSignupPage />} />
        </Routes>

  )
}

