const KEYS = {
    companies: 'companies',
    compId: 'compId'
}

export const getStockExchangeCollection = () => ([
    { id: '1', title: 'BSE' },
    { id: '2', title: 'NSE' }
])

export function insertCompany(data) {
    let companies = getAllCompanies();
    data['id'] = generateCompanyId()
    companies.push(data)
    localStorage.setItem(KEYS.companies, JSON.stringify(companies))
}

export function updateCompany(data) {
    let companies = getAllCompanies();
    let recordIndex = companies.findIndex(x => x.id === data.id);
    companies[recordIndex] = { ...data }
    localStorage.setItem(KEYS.companies, JSON.stringify(companies));
}

export function deleteCompany(id) {
    let companies = getAllCompanies();
    companies = companies.filter(x => x.id !== id)
    localStorage.setItem(KEYS.companies, JSON.stringify(companies));
}

export function generateCompanyId() {
    if (localStorage.getItem(KEYS.compId) == null)
        localStorage.setItem(KEYS.compId, '0')
    var id = parseInt(localStorage.getItem(KEYS.compId))
    localStorage.setItem(KEYS.compId, (++id).toString())
    return id;
}

export function getAllCompanies() {
    if (localStorage.getItem(KEYS.companies) == null)
        localStorage.setItem(KEYS.companies, JSON.stringify([]))
    let companies = JSON.parse(localStorage.getItem(KEYS.companies));
    //map departmentID to department title
    let stockExchangeList = getStockExchangeCollection();
    return companies.map(x => ({
        ...x,
        stockExchange: stockExchangeList[x.stockExchange - 1].title
    }))
}