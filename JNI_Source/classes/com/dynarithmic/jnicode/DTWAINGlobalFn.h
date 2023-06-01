/*
    This file is part of the Dynarithmic TWAIN Library (DTWAIN).
    Copyright (c) 2002-2023 Dynarithmic Software.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

    FOR ANY PART OF THE COVERED WORK IN WHICH THE COPYRIGHT IS OWNED BY
    DYNARITHMIC SOFTWARE. DYNARITHMIC SOFTWARE DISCLAIMS THE WARRANTY OF NON INFRINGEMENT
    OF THIRD PARTY RIGHTS.
 */
#ifndef DTWAINGLOBALFN_H
#define DTWAINGLOBALFN_H

#include "dtwain.h"
#include <unordered_map>
#include <string>
#include <windows.h>
#include <memory>
#include <vector>

struct FnGlobalBase
{
    virtual ~FnGlobalBase() { }
    virtual bool isEmpty() {return true;}
};

template <typename FnType, typename ReturnType>
struct FnGlobal : FnGlobalBase
{
    typedef FnType value_type;
    typedef ReturnType return_type;
    typedef std::unordered_map<std::string, FnType> DTWAINFN_Map;
    DTWAINFN_Map m_FnMap;
    bool isEmpty() { return m_FnMap.empty(); }
};

#define DEFINE_DTWAIN_SMART_POINTER(RetValue, Sig) \
    typedef FnGlobal<DTWAINFN_##Sig, RetValue> FnGlobal##Sig; \
    typedef std::shared_ptr<FnGlobal##Sig> FnGlobal##Sig##Ptr;

#define DEFINE_DTWAIN_FUNCTION_SIGNATURE0(RetValue, Sig) typedef RetValue (__stdcall *DTWAINFN_##Sig)(); \
                                                    DEFINE_DTWAIN_SMART_POINTER(RetValue,##Sig)

#define DEFINE_DTWAIN_FUNCTION_SIGNATURE1(RetValue, Sig, a1) typedef RetValue (__stdcall *DTWAINFN_##Sig)(a1); \
                                                    DEFINE_DTWAIN_SMART_POINTER(RetValue,##Sig)

#define DEFINE_DTWAIN_FUNCTION_SIGNATURE2(RetValue, Sig, a1, a2) typedef RetValue (__stdcall *DTWAINFN_##Sig)(a1, a2); \
                                                    DEFINE_DTWAIN_SMART_POINTER(RetValue,##Sig)

#define DEFINE_DTWAIN_FUNCTION_SIGNATURE3(RetValue, Sig, a1, a2, a3) typedef RetValue (__stdcall *DTWAINFN_##Sig)(a1, a2, a3); \
                                                    DEFINE_DTWAIN_SMART_POINTER(RetValue,##Sig)

#define DEFINE_DTWAIN_FUNCTION_SIGNATURE4(RetValue, Sig, a1, a2, a3, a4) typedef RetValue (__stdcall *DTWAINFN_##Sig)(a1, a2, a3, a4); \
                                                    DEFINE_DTWAIN_SMART_POINTER(RetValue,##Sig)

#define DEFINE_DTWAIN_FUNCTION_SIGNATURE5(RetValue, Sig, a1, a2, a3, a4, a5) typedef RetValue (__stdcall *DTWAINFN_##Sig)(a1, a2, a3, a4, a5); \
                                                    DEFINE_DTWAIN_SMART_POINTER(RetValue,##Sig)

#define DEFINE_DTWAIN_FUNCTION_SIGNATURE6(RetValue, Sig, a1, a2, a3, a4, a5, a6) typedef RetValue (__stdcall *DTWAINFN_##Sig)(a1, a2, a3, a4, a5, a6); \
                                                    DEFINE_DTWAIN_SMART_POINTER(RetValue,##Sig)

#define DEFINE_DTWAIN_FUNCTION_SIGNATURE7(RetValue, Sig, a1, a2, a3, a4, a5, a6, a7) typedef RetValue (__stdcall *DTWAINFN_##Sig)(a1, a2, a3, a4, a5, a6, a7); \
                                                    DEFINE_DTWAIN_SMART_POINTER(RetValue,##Sig)

#define DEFINE_DTWAIN_FUNCTION_SIGNATURE8(RetValue, Sig, a1, a2, a3, a4, a5, a6, a7, a8) typedef RetValue (__stdcall *DTWAINFN_##Sig)(a1, a2, a3, a4, a5, a6, a7, a8); \
                                                    DEFINE_DTWAIN_SMART_POINTER(RetValue,##Sig)

#define DEFINE_DTWAIN_FUNCTION_SIGNATURE9(RetValue, Sig, a1, a2, a3, a4, a5, a6, a7, a8, a9) typedef RetValue (__stdcall *DTWAINFN_##Sig)(a1, a2, a3, a4, a5, a6, a7, a8, a9); \
                                                    DEFINE_DTWAIN_SMART_POINTER(RetValue,##Sig)

DEFINE_DTWAIN_FUNCTION_SIGNATURE0(LONG, LV)
DEFINE_DTWAIN_FUNCTION_SIGNATURE0(DTWAIN_SOURCE, SV)
DEFINE_DTWAIN_FUNCTION_SIGNATURE0(HWND, HV)
DEFINE_DTWAIN_FUNCTION_SIGNATURE0(DTWAIN_ARRAY, AV)
DEFINE_DTWAIN_FUNCTION_SIGNATURE0(HANDLE, HandleV)
DEFINE_DTWAIN_FUNCTION_SIGNATURE0(DTWAIN_OCRENGINE, OV)

DEFINE_DTWAIN_FUNCTION_SIGNATURE1(DTWAIN_BOOL, La, LPDTWAIN_ARRAY)
DEFINE_DTWAIN_FUNCTION_SIGNATURE1(DTWAIN_BOOL, BH, DTWAIN_HANDLE)
DEFINE_DTWAIN_FUNCTION_SIGNATURE1(LONG, LL, LONG)
DEFINE_DTWAIN_FUNCTION_SIGNATURE1(LONG, LO, DTWAIN_OCRENGINE)
DEFINE_DTWAIN_FUNCTION_SIGNATURE1(LONG, LS, DTWAIN_SOURCE)
DEFINE_DTWAIN_FUNCTION_SIGNATURE1(LONG, LA, DTWAIN_ARRAY)
DEFINE_DTWAIN_FUNCTION_SIGNATURE1(DTWAIN_SOURCE, St, LPCTSTR)
DEFINE_DTWAIN_FUNCTION_SIGNATURE1(LONG, Lt, LPCTSTR)
DEFINE_DTWAIN_FUNCTION_SIGNATURE1(HANDLE, HandleS, DTWAIN_SOURCE)
DEFINE_DTWAIN_FUNCTION_SIGNATURE1(DTWAIN_OCRENGINE, Ot, LPCTSTR)
DEFINE_DTWAIN_FUNCTION_SIGNATURE1(TWAIN_IDENTITY, WW, TW_IDENTITY*)
DEFINE_DTWAIN_FUNCTION_SIGNATURE1(HANDLE, HL, LONG)
DEFINE_DTWAIN_FUNCTION_SIGNATURE1(DTWAIN_BOOL, LH, HANDLE)

DEFINE_DTWAIN_FUNCTION_SIGNATURE2(LONG, LSa, DTWAIN_SOURCE, LPDTWAIN_ARRAY)
DEFINE_DTWAIN_FUNCTION_SIGNATURE2(LONG, LSL, DTWAIN_SOURCE, LONG)
DEFINE_DTWAIN_FUNCTION_SIGNATURE2(LONG, LSF, DTWAIN_SOURCE, DTWAIN_FLOAT)
DEFINE_DTWAIN_FUNCTION_SIGNATURE2(LONG, LSl, DTWAIN_SOURCE, LPLONG)
DEFINE_DTWAIN_FUNCTION_SIGNATURE2(LONG, LSf, DTWAIN_SOURCE, LPDTWAIN_FLOAT)
DEFINE_DTWAIN_FUNCTION_SIGNATURE2(LONG, LST, DTWAIN_SOURCE, LPTSTR)
DEFINE_DTWAIN_FUNCTION_SIGNATURE2(LONG, LTL, LPTSTR, LONG)
DEFINE_DTWAIN_FUNCTION_SIGNATURE2(LONG, LSt, DTWAIN_SOURCE, LPCTSTR)
DEFINE_DTWAIN_FUNCTION_SIGNATURE2(LONG, LHF, HANDLE, DTWAIN_FLOAT)
DEFINE_DTWAIN_FUNCTION_SIGNATURE2(DTWAIN_BOOL, LLt, LONG, LPCTSTR)
DEFINE_DTWAIN_FUNCTION_SIGNATURE2(DTWAIN_BOOL, Ltt, LPCTSTR, LPCTSTR)
DEFINE_DTWAIN_FUNCTION_SIGNATURE2(DTWAIN_BOOL, LSH, DTWAIN_SOURCE, HANDLE)
DEFINE_DTWAIN_FUNCTION_SIGNATURE2(DTWAIN_BOOL, LLa, DTWAIN_OCRENGINE, LPDTWAIN_ARRAY)
DEFINE_DTWAIN_FUNCTION_SIGNATURE2(LONG, LLL, LONG, LONG)
DEFINE_DTWAIN_FUNCTION_SIGNATURE2(LONG, LSB, DTWAIN_SOURCE, DTWAIN_BOOL)
DEFINE_DTWAIN_FUNCTION_SIGNATURE2(LONG, LHt, HWND, LPCTSTR);
DEFINE_DTWAIN_FUNCTION_SIGNATURE2(TWAIN_IDENTITY, WSW, DTWAIN_SOURCE, TW_IDENTITY*)

DEFINE_DTWAIN_FUNCTION_SIGNATURE3(LONG,LSLl,DTWAIN_SOURCE, LONG, LPLONG)
DEFINE_DTWAIN_FUNCTION_SIGNATURE3(LONG,LSaB, DTWAIN_SOURCE, LPDTWAIN_ARRAY, DTWAIN_BOOL)
DEFINE_DTWAIN_FUNCTION_SIGNATURE3(LONG,LSLL,DTWAIN_SOURCE, LONG, LONG)
DEFINE_DTWAIN_FUNCTION_SIGNATURE3(LONG,LSFF,DTWAIN_SOURCE, DTWAIN_FLOAT, DTWAIN_FLOAT)
DEFINE_DTWAIN_FUNCTION_SIGNATURE3(LONG,LLTL,LONG, LPTSTR, LONG)

DEFINE_DTWAIN_FUNCTION_SIGNATURE4(LONG,LSLLa,DTWAIN_SOURCE, LONG, LONG, DTWAIN_ARRAY)
DEFINE_DTWAIN_FUNCTION_SIGNATURE4(LONG,LSLFF,DTWAIN_SOURCE, LONG, DTWAIN_FLOAT, DTWAIN_FLOAT)
DEFINE_DTWAIN_FUNCTION_SIGNATURE4(LONG,LSFLL,DTWAIN_SOURCE, DTWAIN_FLOAT, LONG, DTWAIN_BOOL)
DEFINE_DTWAIN_FUNCTION_SIGNATURE4(DTWAIN_BOOL, LSLLA,DTWAIN_SOURCE, LONG , LONG, LPDTWAIN_ARRAY)
DEFINE_DTWAIN_FUNCTION_SIGNATURE4(DTWAIN_BOOL,LSlll,DTWAIN_SOURCE, LPLONG, LPLONG, LPLONG)
DEFINE_DTWAIN_FUNCTION_SIGNATURE4(DTWAIN_BOOL,LTTTT,LPTSTR, LPTSTR, LPTSTR, LPTSTR)
DEFINE_DTWAIN_FUNCTION_SIGNATURE4(DTWAIN_BOOL,Ltttt,LPCTSTR, LPCTSTR, LPCTSTR, LPCTSTR)
DEFINE_DTWAIN_FUNCTION_SIGNATURE4(DTWAIN_BOOL, LLLLa, LONG, LONG, LONG, LPDTWAIN_ARRAY)
DEFINE_DTWAIN_FUNCTION_SIGNATURE4(DTWAIN_BOOL, LLLLA, LONG, LONG, LONG, DTWAIN_ARRAY)
DEFINE_DTWAIN_FUNCTION_SIGNATURE4(DTWAIN_BOOL, LLtLL, LONG, LPCTSTR, LONG, LONG)
DEFINE_DTWAIN_FUNCTION_SIGNATURE4(DTWAIN_BOOL, LOLLa, DTWAIN_OCRENGINE, LONG, LONG, LPDTWAIN_ARRAY)
DEFINE_DTWAIN_FUNCTION_SIGNATURE4(DTWAIN_BOOL, LOLLA, DTWAIN_OCRENGINE, LONG, LONG, DTWAIN_ARRAY)
DEFINE_DTWAIN_FUNCTION_SIGNATURE4(LONG, LOtLL, DTWAIN_OCRENGINE, LPCTSTR, LONG, LONG)
DEFINE_DTWAIN_FUNCTION_SIGNATURE4(DTWAIN_BOOL, LSLBB, DTWAIN_SOURCE, LONG, DTWAIN_BOOL, DTWAIN_BOOL)

DEFINE_DTWAIN_FUNCTION_SIGNATURE5(DTWAIN_SOURCE,SHtLLL,HWND, LPCTSTR, LONG, LONG, LONG)
DEFINE_DTWAIN_FUNCTION_SIGNATURE5(DTWAIN_BOOL,LSLLLa,DTWAIN_SOURCE, LONG , LONG, LONG, DTWAIN_ARRAY)
DEFINE_DTWAIN_FUNCTION_SIGNATURE5(DTWAIN_BOOL, LSLLLA, DTWAIN_SOURCE, LONG , LONG, LONG, LPDTWAIN_ARRAY)
DEFINE_DTWAIN_FUNCTION_SIGNATURE5(DTWAIN_BOOL, LSFLLL, DTWAIN_SOURCE, DTWAIN_FLOAT, LONG, LONG, LONG)

DEFINE_DTWAIN_FUNCTION_SIGNATURE6(LONG,LSLttLL,DTWAIN_SOURCE, DTWAIN_BOOL, LPCTSTR, LPCTSTR, LONG, DTWAIN_BOOL)
DEFINE_DTWAIN_FUNCTION_SIGNATURE6(LONG, LOLLLLL, DTWAIN_OCRENGINE, LONG, LONG, LONG, LONG, LONG)
DEFINE_DTWAIN_FUNCTION_SIGNATURE6(HANDLE, HOLTLlL, DTWAIN_OCRENGINE, LONG, LPTSTR, LONG, LPLONG, LONG)

DEFINE_DTWAIN_FUNCTION_SIGNATURE6(DTWAIN_BOOL,LSLLLLa,DTWAIN_SOURCE, LONG , LONG, LONG, LONG, DTWAIN_ARRAY)
DEFINE_DTWAIN_FUNCTION_SIGNATURE6(DTWAIN_BOOL,LSLLLLA,DTWAIN_SOURCE, LONG , LONG, LONG, LONG, LPDTWAIN_ARRAY)
DEFINE_DTWAIN_FUNCTION_SIGNATURE6(DTWAIN_BOOL,LSffffl,DTWAIN_SOURCE, LPDTWAIN_FLOAT, LPDTWAIN_FLOAT, LPDTWAIN_FLOAT, LPDTWAIN_FLOAT, LPLONG)
DEFINE_DTWAIN_FUNCTION_SIGNATURE6(DTWAIN_BOOL,LLLLLLL,LONG, LONG, LONG, LONG, LONG, LONG)
DEFINE_DTWAIN_FUNCTION_SIGNATURE6(HANDLE, HLLTLlL, LONG, LONG, LPTSTR, LONG, LPLONG, LONG)

DEFINE_DTWAIN_FUNCTION_SIGNATURE7(DTWAIN_BOOL,LSFFFFLL,DTWAIN_SOURCE, DTWAIN_FLOAT, DTWAIN_FLOAT, DTWAIN_FLOAT, DTWAIN_FLOAT, LONG, LONG)
DEFINE_DTWAIN_FUNCTION_SIGNATURE8(DTWAIN_BOOL, LSlllllll, DTWAIN_SOURCE, LPLONG, LPLONG,LPLONG, LPLONG, LPLONG,LPLONG, LPLONG)
DEFINE_DTWAIN_FUNCTION_SIGNATURE9(DTWAIN_BOOL,LSaLLLLLLl,DTWAIN_SOURCE, DTWAIN_ARRAY, LONG, LONG, LONG, LONG, DTWAIN_BOOL, DTWAIN_BOOL, LPLONG)
DEFINE_DTWAIN_FUNCTION_SIGNATURE9(DTWAIN_BOOL,LStLLLLLLl,DTWAIN_SOURCE, LPCTSTR, LONG, LONG, LONG, LONG, DTWAIN_BOOL, DTWAIN_BOOL, LPLONG)

typedef std::shared_ptr<FnGlobalBase> FnGlobalBasePtr;

bool IsModuleInitialized();
void AddToFunctionCounter(const std::string& fname);
void CheckForDuplicateCalls();
#endif