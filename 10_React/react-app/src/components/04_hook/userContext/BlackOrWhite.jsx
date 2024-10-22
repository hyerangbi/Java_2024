import React, {userState} from 'react'
import MainContent from './MainContent'
import ThemeContext from './ThemeContext'

const BlackorWhite = () => {
    const [theme, setTheme] = userState("white")

    const toggleTheme = () => {
        if(theme === "white"){
            setTheme("black")
        } else{
            setTheme("white")
        }
    }

    return (
        <ThemeContext.Provider value={{theme, toggleTheme}}>
            <MainContent theme = {theme} toggleTheme = {toggleTheme} />
        </ThemeContext.Provider>
    )
}

export default BlackorWhite