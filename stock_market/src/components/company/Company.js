import React, { useState } from 'react';
import { Paper, makeStyles, TableBody, TableRow, TableCell, Toolbar, InputAdornment } from '@material-ui/core';
import AddIcon from '@material-ui/icons/Add';
import EditOutlinedIcon from '@material-ui/icons/EditOutlined';
import CloseIcon from '@material-ui/icons/Close';

import * as companyService from "../../services/CompanyService"
import PageHeader from "../Layout/PageHeader"
import CompanyForm from './CompanyForm';
import useTable from "../useTable"
import Controls from '../Controls/Controls';
import Notification from "../Notification";
import ConfirmDialog from '../ConfirmDialog';
import Popup from "../Popup";


const useStyles = makeStyles(theme => ({
    pageContent: {
        margin: theme.spacing(5),
        padding: theme.spacing(3)
    },
    searchInput: {
        width: '75%'
    },
    newButton: {
        position: 'absolute',
        right: '10px'
    }
}))

const headCells = [
    { id: 'compId', label: 'Company ID' },
    { id: 'companyName', label: 'Company Name' },
    { id: 'companyCeo', label: 'Company CEO' },
    { id: 'companyWebsite', label: 'Company Website' },
    { id: 'companyTurnover', label: 'Company Turnover' },
    { id: 'actions', label: 'Actions', disableSorting: true }
]

export default function Company() {
    const classes = useStyles();
    const [recordForEdit, setRecordForEdit] = useState(null)
    const [records, setRecords] = useState(companyService.getAllCompanies())
    const [filterFn, setFilterFn] = useState({ fn: items => { return items; } })
    const [openPopup, setOpenPopup] = useState(false)
    const [notify, setNotify] = useState({ isOpen: false, message: '', type: '' })
    const [confirmDialog, setConfirmDialog] = useState({ isOpen: false, title: '', subTitle: '' })

    const {
        TblContainer,
        TblHead,
        TblPagination,
        recordsAfterPagingAndSorting
    } = useTable(records, headCells, filterFn);

    const handleSearch = e => {
        let target = e.target;
        setFilterFn({
            fn: items => {
                if (target.value === "")
                    return items;
                else
                    return items.filter(x => x.companyName.toLowerCase().includes(target.value))
            }
        })
    }

    const addOrEdit = (company, resetForm) => {
        if (company.compId === 0)
            companyService.insertCompany(company)
        else
            companyService.updateCompany(company)
        resetForm()
        setRecordForEdit(null)
        setOpenPopup(false)
        setRecords(companyService.getAllCompanies())
        setNotify({
            isOpen: true,
            message: 'Submitted Successfully',
            type: 'success'
        })
    }

    const openInPopup = item => {
        setRecordForEdit(item)
        setOpenPopup(true)
    }

    const onDelete = id => {
        setConfirmDialog({
            ...confirmDialog,
            isOpen: false
        })
        companyService.deleteCompany(id);
        setRecords(companyService.getAllCompanies())
        setNotify({
            isOpen: true,
            message: 'Deleted Successfully',
            type: 'error'
        })
    }

    return (
        <>
            <PageHeader />
            <Paper>
                <Toolbar>
                    <Controls.Input />
                    <Controls.Button />
                </Toolbar>
                <TblContainer>
                    <TblHead />
                    <TableBody>
                        {
                            recordsAfterPagingAndSorting().map(item => (
                                <TableRow key={item.compId}>
                                    <TableCell>{item.companyName}</TableCell>
                                    <TableCell>{item.companyName}</TableCell>
                                    <TableCell>
                                        <Controls.ActionButton
                                            color="primary"
                                            onClick={() => { openInPopup(item) }}>
                                            <EditOutlinedIcon fontSize="small" />
                                        </Controls.ActionButton>
                                        <Controls.ActionButton
                                            color="secondary"
                                            onClick={() => {
                                                setConfirmDialog({
                                                    isOpen: true,
                                                    title: 'Are you sure to delete this record?',
                                                    subTitle: "You can't undo this operation",
                                                    onConfirm: () => { onDelete(item.id) }
                                                })
                                            }}>
                                            <CloseIcon fontSize="small" />
                                        </Controls.ActionButton>
                                    </TableCell>

                                </TableRow>
                            ))
                        }
                    </TableBody>
                </TblContainer>
                <TblPagination />
            </Paper>
            <Popup
                title="Company Form"
                openPopup={openPopup}
                setOpenPopup={setOpenPopup}
            >
                <CompanyForm
                    recordForEdit={recordForEdit}
                    addOrEdit={addOrEdit}
                />
            </Popup>
            <Notification
                notify={notify}
                setNotify={setNotify}
            />
            <ConfirmDialog
                confirmDialog={confirmDialog}
                setConfirmDialog={setConfirmDialog}
            />
        </>
    )
}
