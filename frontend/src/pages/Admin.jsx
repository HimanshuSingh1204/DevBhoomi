import React, { useEffect, useState } from 'react';
import api from '../services/api';

const Admin = () => {
  const [users, setUsers] = useState([]);
  const [places, setPlaces] = useState([]);
  const [packages, setPackages] = useState([]);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const [usersRes, placesRes, packagesRes] = await Promise.all([
          api.get('/admin/users'),
          api.get('/admin/places'),
          api.get('/admin/packages')
        ]);
        setUsers(usersRes.data);
        setPlaces(placesRes.data);
        setPackages(packagesRes.data);
      } catch (error) {
        console.error('Failed to fetch admin data', error);
      }
    };
    fetchData();
  }, []);

  return (
    <div className="max-w-7xl mx-auto py-6 sm:px-6 lg:px-8">
      <h1 className="text-3xl font-bold text-gray-900 mb-6">Admin Dashboard</h1>

      <div className="mb-8">
        <h2 className="text-2xl font-semibold mb-4">Users</h2>
        <div className="bg-white shadow overflow-hidden sm:rounded-md">
          <ul className="divide-y divide-gray-200">
            {users.map(user => (
              <li key={user.id} className="px-6 py-4">
                <div className="flex items-center justify-between">
                  <div>
                    <p className="text-sm font-medium text-gray-900">{user.username}</p>
                    <p className="text-sm text-gray-500">{user.email}</p>
                  </div>
                  <p className="text-sm text-gray-500">{user.role}</p>
                </div>
              </li>
            ))}
          </ul>
        </div>
      </div>

      <div className="mb-8">
        <h2 className="text-2xl font-semibold mb-4">Places</h2>
        <div className="bg-white shadow overflow-hidden sm:rounded-md">
          <ul className="divide-y divide-gray-200">
            {places.map(place => (
              <li key={place.id} className="px-6 py-4">
                <div className="flex items-center justify-between">
                  <div>
                    <p className="text-sm font-medium text-gray-900">{place.name}</p>
                    <p className="text-sm text-gray-500">{place.category}</p>
                  </div>
                  <p className="text-sm text-gray-500">${place.cost}</p>
                </div>
              </li>
            ))}
          </ul>
        </div>
      </div>

      <div>
        <h2 className="text-2xl font-semibold mb-4">Travel Packages</h2>
        <div className="bg-white shadow overflow-hidden sm:rounded-md">
          <ul className="divide-y divide-gray-200">
            {packages.map(pkg => (
              <li key={pkg.id} className="px-6 py-4">
                <div className="flex items-center justify-between">
                  <div>
                    <p className="text-sm font-medium text-gray-900">{pkg.name}</p>
                    <p className="text-sm text-gray-500">{pkg.duration} days</p>
                  </div>
                  <p className="text-sm text-gray-500">${pkg.price}</p>
                </div>
              </li>
            ))}
          </ul>
        </div>
      </div>
    </div>
  );
};

export default Admin;