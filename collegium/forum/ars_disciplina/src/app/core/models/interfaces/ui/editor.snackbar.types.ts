export type SnackbarState =
    | 'loading'
    | 'success'
    | 'error'
    | 'warning'
    | 'info';

export interface Snackbar {
    message: string;
    state: SnackbarState;
}