import React, { useEffect, useState } from 'react';
import api from '../services/api';

const VideoFeed = () => {
  const [videos, setVideos] = useState([]);

  useEffect(() => {
    const fetchVideos = async () => {
      try {
        const response = await api.get('/videos');
        setVideos(response.data);
      } catch (error) {
        console.error('Failed to fetch videos', error);
      }
    };
    fetchVideos();
  }, []);

  return (
    <div className="max-w-4xl mx-auto mt-10">
      {videos.map(video => (
        <div key={video.id} className="bg-white p-4 rounded shadow-md mb-4">
          <video controls className="w-full">
            <source src={video.url} type="video/mp4" />
          </video>
          <p className="mt-2">{video.caption}</p>
        </div>
      ))}
    </div>
  );
};

export default VideoFeed;