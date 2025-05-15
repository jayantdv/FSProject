
import React, { useState, useEffect } from 'react';
import axios from 'axios';
import 'bootstrap/dist/css/bootstrap.min.css';

function App() {
  const [shows, setShows] = useState([]);
  const [selectedShow, setSelectedShow] = useState(null);

  useEffect(() => {
    axios.get('/api/tvshows')
      .then(response => setShows(response.data))
      .catch(error => console.error('Error fetching TV shows:', error));
  }, []);

  const handleShowClick = (show) => {
    setSelectedShow(show);
  };

  return (
    <div className="container">
      <h1 className="my-4">TV Show Explorer</h1>
      {selectedShow ? (
        <div className="card mb-4">
          <div className="card-header">
            <h2>{selectedShow.name}</h2>
          </div>
          <div className="card-body">
            <p><strong>Network:</strong> {selectedShow.network}</p>
            <p><strong>Status:</strong> {selectedShow.status}</p>
            <p><strong>Schedule:</strong> {selectedShow.schedule}</p>
            <p><strong>Summary:</strong> {selectedShow.summary}</p>
            <button className="btn btn-primary" onClick={() => setSelectedShow(null)}>Back to List</button>
          </div>
        </div>
      ) : (
        <div>
          <h2>TV Show List</h2>
          <ul className="list-group">
            {shows.map((show, index) => (
              <li 
                key={index} 
                className="list-group-item list-group-item-action"
                onClick={() => handleShowClick(show)}
              >
                {show.name}
              </li>
            ))}
          </ul>
        </div>
      )}
    </div>
  );
}

export default App;
