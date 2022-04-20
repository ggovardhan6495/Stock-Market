import { AppBar, Badge, Button, Grid, IconButton, InputBase, makeStyles, Toolbar, Typography } from '@material-ui/core';
import React from 'react';
import NotificationsNoneIcon from '@material-ui/icons/NotificationsNone';
import ChatBubbleOutlineIcon from '@material-ui/icons/ChatBubbleOutline';
import PowerSettingsNewIcon from '@material-ui/icons/PowerSettingsNew';

const useStyles = makeStyles(theme => ({
    root: {
        backgroundColor: '#fff',

    },
    title: {
        flexGrow: 1,
    },
    searchInput: {
        opacity: '0.6',
        padding: `0px ${theme.spacing(1)}px`,
        fontSize: '0.8rem',
        '&:hover': {
            backgroundColor: '#f2f2f2'
        },
        '& .MuiSvgIcon-root': {
            marginRight: theme.spacing(1)
        }
    }
}))
function Header() {
    const classes = useStyles();
    return (
        <AppBar>
            <Toolbar>
                <Grid container allignItems="center">
                    <Grid item sm>
                        <Typography variant="h5" className={classes.title}>StockMarket</Typography>
                    </Grid>
                    <Grid item sm></Grid>
                    <Grid item>
                        <IconButton>
                            <Badge badgeContent={5} color="secondary">
                                <NotificationsNoneIcon fontSize="small" />
                            </Badge>
                        </IconButton>
                        <IconButton>
                            <Badge badgeContent={3} color="primary">
                                <ChatBubbleOutlineIcon fontSize="small" />
                            </Badge>
                        </IconButton>
                        <IconButton>
                            <PowerSettingsNewIcon fontSize="small" />
                        </IconButton>                    </Grid>
                </Grid>
            </Toolbar>
        </AppBar>
    )
}

export default Header;