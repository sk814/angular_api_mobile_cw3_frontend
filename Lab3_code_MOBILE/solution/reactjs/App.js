import React from 'react';
import logo from './logo.svg';
import './App.css';
import Table from './TableData'

export default class App extends React.Component {
    constructor(props){
      super(props);
      this.state={
        tableData:[
          {'module': 'CO3102 Mobile and Web apps', 'mark': 100},
          {'module': 'CO3201 Third-Year Project', 'mark': 50},
          {'module': 'CO7210 Personal Group skills', 'mark': 35}
        ]
      }
    }
    
    
    render() {
        
        
        return (
          <div className="App" >
            Module list
            <br/> Table 1 data
            <Table data={this.state.tableData}/>
          </div>
          
        );
    }
    
   
}

/*
function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>
    </div>
  );
}

export default App;

*/
