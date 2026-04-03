import React, { useState } from 'react';
import api from '../services/api';

const VideoUpload = () => {
  const [file, setFile] = useState(null);
  const [caption, setCaption] = useState('');

  const handleSubmit = async (e) => {
    e.preventDefault();
    const formData = new FormData();
    formData.append('file', file);
    formData.append('caption', caption);
    formData.append('userId', 1); // Assume user ID

    try {
      await api.post('/videos/upload', formData, {
        headers: { 'Content-Type': 'multipart/form-data' }
      });
      alert('Video uploaded successfully');
    } catch (error) {
      console.error('Upload failed', error);
    }
  };

  return (
    <div className="max-w-md mx-auto mt-10">
      <form onSubmit={handleSubmit} className="bg-white p-6 rounded shadow-md">
        <input type="file" onChange={(e) => setFile(e.target.files[0])} accept="video/*" className="mb-4" />
        <input type="text" value={caption} onChange={(e) => setCaption(e.target.value)} placeholder="Caption" className="w-full p-2 border mb-4" />
        <button type="submit" className="w-full bg-blue-500 text-white p-2 rounded">Upload</button>
      </form>
    </div>
  );
};

export default VideoUpload;