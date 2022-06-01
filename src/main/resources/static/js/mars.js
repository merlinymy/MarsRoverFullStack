// Get url and get value of a search parameter
let url_string = window.location.href
let url = new URL(url_string)

//store user data to local
let userId = url.searchParams.get('userId')

if (userId == null || userId == '') {
    userId = localStorage.getItem('userId')
}

if (userId !== null && userId !== '') {
    localStorage.setItem('userId', userId)
    document.getElementById('userId').value = userId
}

const buttons = document.querySelectorAll("button[id^='Mars']")

buttons.forEach(button => button.addEventListener('click', function () {
    const buttonId = this.id
    const roverId = buttonId.split('Mars')[1]
    let apiData = document.getElementById('roverName')
    apiData.value = roverId;
    document.getElementById('formRoverName').submit()
}))



let sol = document.getElementById('sol').value
let roverTypes = document.getElementById('roverName').value
highlightBtnByRoverType(roverTypes)
if (sol != null && sol !== '' && sol >= 0) {
    document.getElementById('sol').value = sol
}
function highlightBtnByRoverType(roverType) {
    if ((roverType == null || roverType === '')) {
        roverType = 'Spirit'
    }
    document.getElementById('Mars'+roverType).classList.replace('btn-outline-primary', 'btn-primary')
}