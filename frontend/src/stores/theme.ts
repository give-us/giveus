import { atom } from 'recoil'

export enum ThemeFlag {
  light,
  dark,
}

export const themeState = atom<ThemeFlag>({
  key: 'THEME_SATE',
  default: ThemeFlag.light,
})
