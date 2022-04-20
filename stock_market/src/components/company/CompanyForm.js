// import { ControlPointSharp } from '@material-ui/icons';
import React, { useEffect } from 'react';
import { Grid } from '@material-ui/core';
import Controls from '../Controls/Controls';
import { useForm, Form } from '../../components/useForm';
import * as companyService from "../../services/CompanyService"

const initialFValues = {
    compId: 0,
    companyName: '',
    companyCeo: '',
    companyWebsite: '',
    companyTurnover: '',
    hireDate: new Date(),
    stockExchange: ''
}

function CompanyForm(props) {
    const { addOrEdit, recordForEdit } = props
    const validate = (fieldValues = values) => {
        let temp = { ...errors }
        if ('compId' in fieldValues)
            temp.compId = fieldValues.compId ? "" : "This field is required."
        if ('companyName' in fieldValues)
            temp.companyName = fieldValues.companyName ? "" : "This field is required."
        if ('companyCeo' in fieldValues)
            temp.companyCeo = fieldValues.companyCeo ? "" : "This field is required."
        if ('companyWebsite' in fieldValues)
            temp.companyWebsite = fieldValues.companyWebsite ? "" : "This field is required."
        if ('companyTurnover' in fieldValues)
            temp.companyTurnover = fieldValues.companyTurnover ? "" : "This field is required."
        setErrors({
            ...temp
        })
        if (fieldValues === values)
            return Object.values(temp).every(x => x === "")
    }
    const {
        values,
        setValues,
        errors,
        setErrors,
        handleInputChange,
        resetForm
    } = useForm(initialFValues, true, validate);

    const handleSubmit = e => {
        e.preventDefault()
        if (validate()) {
            addOrEdit(values, resetForm);
        }
    }
    useEffect(() => {
        if (recordForEdit != null)
            setValues({
                ...recordForEdit
            })
    }, [recordForEdit])
    return (
        <Form onSubmit={handleSubmit}>
            <Grid container>
                <Grid item xs={6}>
                    <Controls.Input
                        label="compId"
                        name="Company Id"
                        value={values.compId}
                        onChange={handleInputChange}
                        error={errors.compId}
                    />
                    <Controls.Input
                        label="companyName"
                        name="Company Name"
                        value={values.companyName}
                        onChange={handleInputChange}
                        error={errors.companyName}
                    />
                    <Controls.Input
                        label="companyCeo"
                        name="Company CEO"
                        value={values.companyCeo}
                        onChange={handleInputChange}
                        error={errors.companyCeo}
                    />
                    <Controls.Input
                        label="companyWebsite"
                        name="Company Website"
                        value={values.companyWebsite}
                        onChange={handleInputChange}
                        error={errors.companyWebsite}
                    />
                    <Controls.Input
                        label="companyTurnover"
                        name="Company Turnover"
                        value={values.companyTurnover}
                        onChange={handleInputChange}
                        error={errors.companyTurnover}
                    />
                </Grid>
                <Grid item xs={6}>
                    <Controls.DatePicker
                        name="hireDate"
                        label="Hire Date"
                        value={values.hireDate}
                        onChange={handleInputChange}
                    />
                    <Controls.Select
                        label="stockExchange"
                        name="StockExchange"
                        value={values.stockExchange}
                        onChange={handleInputChange}
                        options={companyService.getStockExchangeCollection()}
                        error={errors.stockExchange}
                    />
                    <div>
                        <Controls.Button
                            type="submit"
                            text="Submit"
                        />
                        <Controls.Button
                            text="Reset"
                            color="default"
                            onClick={resetForm}
                        />
                    </div>
                </Grid>
            </Grid>
        </Form>
    );
}
export default CompanyForm; 