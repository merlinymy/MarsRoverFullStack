const buttons = document.querySelectorAll("button[id^='Mars']")

buttons.forEach(button => button.addEventListener('click', function () {
    const buttonId = this.id
    const roverId = buttonId.split('Mars')[1]
    let apiData = document.getElementById('roverData')
    apiData.value = roverId;
    document.getElementById('formRoverName').submit()
}))
// Get url and get value of a search parameter
let url_string = window.location.href
let url = new URL(url_string)
let roverTypes = url.searchParams.get("marsRoverData")

// Highlight btns accordingly
// if (roverType === 'Curiosity') {
//     document.getElementById("MarsCuriosity").classList.replace("btn-outline-primary", "btn-primary")
//
// }else if (roverType === 'Opportunity') {
//     document.getElementById("MarsOpportunity").classList.replace("btn-outline-primary", "btn-primary")
// } else if (roverType === 'Spirit') {
//     document.getElementById("MarsSpirit").classList.replace("btn-outline-primary", "btn-primary")
// } else {
//     document.getElementById("MarsSpirit").classList.replace("btn-outline-primary", "btn-primary")
// }
highlightBtnByRoverType(roverTypes)
function highlightBtnByRoverType(roverType) {
    if (roverType == null) {
        roverType = 'Spirit'
    }
    document.getElementById("Mars"+roverType).classList.replace("btn-outline-primary", "btn-primary")
}