import React from 'react';
import { Link } from 'react-router-dom';
import { useSelector } from 'react-redux';

const Home = () => {
  const { user } = useSelector(state => state.auth);

  return (
    <div className="min-h-screen bg-gray-100">
      <header className="bg-white shadow">
        <div className="max-w-7xl mx-auto py-6 px-4 sm:px-6 lg:px-8 flex justify-between items-center">
          <h1 className="text-3xl font-bold text-gray-900">Explore Uttarakhand</h1>
          <nav className="space-x-4">
            <Link to="/login" className="text-blue-600 hover:text-blue-800">Login</Link>
            <Link to="/register" className="text-blue-600 hover:text-blue-800">Register</Link>
            <Link to="/places" className="text-blue-600 hover:text-blue-800">Places</Link>
            <Link to="/feed" className="text-blue-600 hover:text-blue-800">Video Feed</Link>
            <Link to="/upload" className="text-blue-600 hover:text-blue-800">Upload Video</Link>
            <Link to="/profile" className="text-blue-600 hover:text-blue-800">Profile</Link>
            {user && user.role === 'ADMIN' && <Link to="/admin" className="text-red-600 hover:text-red-800">Admin</Link>}
          </nav>
        </div>
      </header>
      <main>
        <div className="max-w-7xl mx-auto py-6 sm:px-6 lg:px-8">
          <div className="px-4 py-6 sm:px-0">
            <h2 className="text-2xl font-semibold text-gray-900">Welcome to Uttarakhand</h2>
            <p className="mt-2 text-gray-600">Discover the beauty of Uttarakhand with our travel platform.</p>
          </div>
        </div>
      </main>
    </div>
  );
};

export default Home;