import React, { useEffect, useState } from 'react';
import api from '../services/api';
import MapComponent from '../components/MapComponent';

const Places = () => {
  const [places, setPlaces] = useState([]);

  useEffect(() => {
    const fetchPlaces = async () => {
      try {
        const response = await api.get('/places');
        setPlaces(response.data);
      } catch (error) {
        console.error('Failed to fetch places', error);
      }
    };
    fetchPlaces();
  }, []);

  return (
    <div className="max-w-7xl mx-auto py-6 sm:px-6 lg:px-8">
      <h1 className="text-3xl font-bold text-gray-900 mb-6">Places in Uttarakhand</h1>
      <div className="mb-6">
        <MapComponent places={places} />
      </div>
      <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">
        {places.map(place => (
          <div key={place.id} className="bg-white overflow-hidden shadow rounded-lg">
            <div className="p-6">
              <h3 className="text-lg font-medium text-gray-900">{place.name}</h3>
              <p className="mt-2 text-sm text-gray-500">{place.description}</p>
              <p className="mt-2 text-sm text-gray-500">Category: {place.category}</p>
              <p className="mt-2 text-sm text-gray-500">Cost: ${place.cost}</p>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
};

export default Places;