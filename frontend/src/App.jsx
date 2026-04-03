import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Home from './pages/Home';
import Login from './pages/Login';
import Register from './pages/Register';
import Places from './pages/Places';
import Profile from './pages/Profile';
import VideoUpload from './components/VideoUpload';
import VideoFeed from './components/VideoFeed';
import Admin from './pages/Admin';

function App() {
  return (
    <Router>
      <div className="App">
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/login" element={<Login />} />
          <Route path="/register" element={<Register />} />
          <Route path="/places" element={<Places />} />
          <Route path="/profile" element={<Profile />} />
          <Route path="/upload" element={<VideoUpload />} />
          <Route path="/feed" element={<VideoFeed />} />
          <Route path="/admin" element={<Admin />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;